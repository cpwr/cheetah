(ns cheetah.components.sign-in
  (:require [rum.core :as rum]))

(rum/defc sign-in [state]
  [:div {:class "screen signin"}
   [:h1
    [:em "Cheetah"]]
   [:form {:action "" :class "signin"}
    [:input {:type "email" :placeholder "Username"}]
    [:button "Sign In"]]])
