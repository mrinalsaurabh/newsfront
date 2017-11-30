(ns newsfront.views.home.events
    (:require [re-frame.core :refer [reg-event-db reg-event-fx]]
              [newsfront.events]
              [newsfront.config :as config]))

(reg-event-fx  
:fetch-all-news 
    (fn [world [_ _]] 
        (let [uri (str config/backend-url "/api/newsback/all-news/1")] 
            {:db (:db world)  
            :dispatch [:fetch-ajax uri :set-all-news]}))) 

(reg-event-db
    :set-all-news 
    (fn [db [_ news]]
        (assoc-in db [:home :all-news] news)))



