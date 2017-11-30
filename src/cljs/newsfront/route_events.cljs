(ns newsfront.route-events
    (:require [re-frame.core :refer [reg-event-db reg-event-fx]]
              [day8.re-frame.http-fx]
              [cemerick.url :as c-url]
              [ajax.core :as ajax]))
             
(def default-db                                                                                                                                              
    {:name "re-frame"})                                                                                                                                        
                                     
(reg-event-db                                                                                                                                                                   
    :initialize-db                                                                                                                                                                 
    (fn  [_ _]                                                                                                                                                                     
        default-db))

(reg-event-db 
    :current-url
    (fn [db _]
        (let [url (c-url/url (.. js/window
                                -location
                                -href))]
        (assoc-in db [:routes :navigated-url] url))))