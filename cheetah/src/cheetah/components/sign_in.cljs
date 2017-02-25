(ns cheetah.components.sign-in
  (:require [rum.core :as rum]
            [cheetah.core :as core]
            [bide.core :as r]
            [cheetah.state :refer [state]]))

(rum/defc sign-in []
  [:div {:class "screen signin"}
   [:h1
    [:em "Cheetah"]]
   [:form {:action "" :class "signin"}
    [:input {:type "email" :placeholder "Username"}]
    [:button {:on-click  (fn [e] (let [] (core/goto "/rooms") (.preventDefault e))) } "Sign In"]]])
