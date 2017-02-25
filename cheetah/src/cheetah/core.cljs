(ns cheetah.core
  (:require [rum.core :as rum]
            [bide.core :as r]
            [pushy.core :as pushy]
            [cheetah.components.sign-in :as sign-in]
            [cheetah.components.rooms :as rooms]
            [cheetah.components.profile :as profile]
            [cheetah.components.chat :as chat]
            [cheetah.helpers :as h]))

(enable-console-print!)


(def state (atom {:rooms [
                          ["#general" "#general"]
                          ["#random" "#random"]
                          ["#dev-js" "#dev-js"]]
                  :route nil}))

(def router
  (r/router [["/" :sign-in]
             ["/profile" :profile]
             ["/rooms" :rooms]
             ["/rooms/:name" :chat-by-name]]))

(def history
  (pushy/pushy #(swap! state assoc :route %) (partial r/match router)))

(pushy/start! history)

(rum/defc Router < rum/reactive [state]
  (let [{route :route} (rum/react state)
        [route-name segment params] route]
    [:div
     (case route-name
       :sign-in (sign-in/sign-in state)
       :profile (profile/profile state)
       :rooms (rooms/rooms state)
       :chat-by-name (let [name (get segment :name)]
                      (chat/chat name (h/get-chat-messages name)))
       nil)]))

(rum/mount (Router state)
           (. js/document (getElementById "app")))
