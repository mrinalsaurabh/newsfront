(ns newsfront.views.home.subs
    (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
    :all-news
    (fn [db _]
        (get-in db [:home :all-news])))