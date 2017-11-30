(ns newsfront.views.home.index
    (:require [newsfront.views.home.events]
              [newsfront.views.home.subs]
              [re-frame.core :refer [dispatch subscribe]]))

(dispatch [:fetch-all-news])

(defn page []
    (let [all-news @(subscribe [:all-news])]
        (prn all-news)
        [:div {:class "home-body"}
        (map-indexed (fn [idx val]
            [:div {:key idx :dangerouslySetInnerHTML {:__html (:news val)}}]) all-news)
        ]))