(ns newsfront.events
(:require [re-frame.core :refer [reg-event-db reg-event-fx]]
          [day8.re-frame.http-fx]
          [ajax.core :as ajax]))

(reg-event-db 
    :bad-user-response 
    (fn [db [_ data response]] 
        (assoc-in db [:global :enable-error] (select-keys data [:status :uri :last-method])))) 

(reg-event-fx 
    :fetch-ajax
    (fn [_ [_ uri success-event]] 
        {:http-xhrio {:method :get 
                      :uri uri
                      :headers {:Access-Control-Allow-Origin "*"}
                      :format (ajax/json-request-format)
                      :response-format (ajax/json-response-format {:keywords? true})
                      :on-success [success-event]
                      :on-failure [:bad-user-response]}}))
