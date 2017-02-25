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


(def route (atom))


(def router
  (r/router [["/" :sign-in]
             ["/profile" :profile]
             ["/rooms" :rooms]
             ["/rooms/:name" :chat-by-name]]))

(def history
  (pushy/pushy #(reset! route %) (partial r/match router)))

(pushy/start! history)

(rum/defc Router < rum/reactive [route]
  (let [[handler params] (rum/react route)]
    [:div
     (case handler
       :sign-in (sign-in/sign-in)
       :profile (profile/profile)
       :rooms (rooms/rooms [["#general" "#general"]
                            ["#random" "#random"]
                            ["#dev-js" "#dev-js"]])
       :chat-by-name (let [name (get params :name)]
                        (chat/chat name (h/get-chat-messages name)))
       nil)]))

(rum/mount (Router route)
           (. js/document (getElementById "app")))
