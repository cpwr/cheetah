(ns cheetah.components.common
  (:require [rum.core :as rum]))

(rum/defc header [title]
  [:header {:class "app-header"}
   [:div {:class "left"}
    [:div {:class "screen-title"}
     [:span title]]]
   [:div {:class "right"}
    [:button {:class "menu-btn"} "☰"]]])
