(ns newsfront.route-subs
    (:require [re-frame.core :refer [reg-sub]]
              [cemerick.url :as c-url]
              [newsfront.views.not-found.index :as not-found]
              [newsfront.views.home.index :as home]))

(def url-routes
    {["/", "/home"] home/page})

(reg-sub
    :current-page 
    (fn [db _]
        (let [current-url (c-url/url (.. js/window
                                        -location
                                        -href))
              return-element (some (fn [[url-route page-element]]
                                    (if (some (fn [rp]
                                        (= rp (:path current-url))) url-route) 
                                page-element)) url-routes)]
            
                (if return-element return-element not-found/page))))