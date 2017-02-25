(ns cheetah.components.chat
  (:require [rum.core :as rum]
            [cheetah.components.common :as cc]
            [cheetah.helpers :as h]))

(declare message-list)
(declare message)
(declare message-bubble)
(declare message-avatar)
(declare message-form)

(rum/defc chat [name messages]
  [:div {:class "screen chat"}
   (cc/header name)
   (message-list messages)
   (message-form)])

(rum/defc message-list [messages]
  [:main [:ul {:class "chat-list"}
          (map message messages)]])

(rum/defc message [[username message]]
  [:li {:class (str "chat-msg " (if (h/owner? username) "owner"))}
   (cc/avatar (h/avatar-url username))
   (message-bubble username message)])

(rum/defc message-bubble [username message]
  [:div {:class "bubble"}
   [:div {:class "bubble-uname owner"} username]
   [:div {:class "body"} message]])

(rum/defc message-form []
  [:footer {:class "app-footer"}
   [:form {:class "message"}
    [:input {:type "text" :class "message"}]
    [:button {:class "btn send-btn"} "Send"]]])
