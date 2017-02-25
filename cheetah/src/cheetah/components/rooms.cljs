(ns cheetah.components.rooms
   (:require [rum.core :as rum]
             [cheetah.components.common :as cc]))

(declare channel-item)

(rum/defc rooms [state]
          [:div {:class "screen rooms"}
           (cc/header "Chat rooms")
           [:ul {:class "rooms-list"}
            (map channel-item state :rooms)]])

(rum/defc channel-item [[name url]]
  [:li {:class "room-item" :key name}
   [:a {:href url} name]])
