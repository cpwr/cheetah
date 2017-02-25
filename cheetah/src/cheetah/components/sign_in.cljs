(ns cheetah.components.sign-in
  (:require [rum.core :as rum]
            [cheetah.core :as core]
            [bide.core :as r]))

(rum/defc sign-in [state]
  [:div {:class "screen signin"}
   [:h1
    [:em "Cheetah"]]
   [:form {:action "" :class "signin"}
    [:input {:type "email" :placeholder "Username"}]
    [:button {:on-click  (fn [e] (let [] (core/goto "/rooms") (.preventDefault e))) } "Sign In"]]])
