(ns cheetah.components.common
  (:require [rum.core :as rum]))

(rum/defc header
 ([title] (header title nil))
 ([title back-handler]
  [:header {:class "app-header"}
   [:div {:class "left"}
    (if-not back-url [:button {:class "back btn" :on-click back-handler} "<"])
    [:div {:class "screen-title"}
     [:span title]]]
   [:div {:class "right"}
    [:button {:class "menu-btn"} "☰"]]]))
