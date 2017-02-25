(ns cheetah.core
  (:require [rum.core :as rum]
            [bide.core :as r]
            [pushy.core :as pushy]
            [cheetah.components.sign-in :as sign-in]
            [cheetah.components.rooms :as rooms]
            [cheetah.components.profile :as profile]
            [cheetah.components.chat :as chat]
            [cheetah.helpers :as h]
            [cheetah.state :refer [state]]))

(enable-console-print!)

(defn on-navigate [name params query])

(def router
  (r/router [["/" :sign-in]
             ["/profile" :profile]
             ["/rooms" :rooms]
             ["/rooms/:name" :chat-by-name]]))

(def history
  (pushy/pushy #(swap! state assoc :route %) (partial r/match router)))

(pushy/start! history)

(defn goto [url]
  (pushy/set-token! history url))

(rum/defc Router < rum/reactive [state]
  (let [{route :route} (rum/react state)
        [route-name segment params] route]
    [:div
     (case route-name
       :sign-in (sign-in/sign-in)
       :profile (profile/profile)
       :rooms (rooms/rooms (get @state :rooms))
       :chat-by-name (let [name (get params :name)]
                      (chat/chat name (h/get-chat-messages name)))
       nil)]))

(rum/mount (Router state)
           (. js/document (getElementById "app")))
