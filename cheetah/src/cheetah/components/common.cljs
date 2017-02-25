(ns cheetah.components.common
  (:require [rum.core :as rum]))

(rum/defc header
 ([title] (header title nil))
 ([title back-handler]
  [:header {:class "app-header"}
   [:div {:class "left"}
    (if back-handler [:button {:class "back btn" :on-click back-handler}])
    [:div {:class "screen-title"}
     [:span title]]]
   [:div {:class "right"}
    [:button {:class "menu-btn"} "☰"]]]))

(rum/defc avatar [url]
  [:img {:src url :class "avatar"}])
