(ns cheetah.components.profile
  (:require [rum.core :as rum]
            [cheetah.components.common :as cc]
            [cheetah.state :refer [state]]))

(rum/defc profile [state]
  [:div {:class "screen profile"}
   (cc/header "Profile" #(swap! state assoc :route [:rooms nil nil]))
   [:main
    (let [avatar-url "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/3/000/024/157/2fd1a24.jpg"]
         (cc/avatar avatar-url))
    [:form {:action "" :class "profile"}
     [:div {:class "field"}
      [:label {:for "uname"} "User name"]
      [:input {:type "text" :id "uname"}]]
     [:div {:class "field"}
      [:label {:for "avatar"} "Avatar"]
      [:button {:class "btn upload-avatar"} "Choose image"]
      [:input {:type "file" :id "avatar" :accept "image/x-png,image/jpeg" :hidden "hidden"}]]
     [:button "Save"]]]])
