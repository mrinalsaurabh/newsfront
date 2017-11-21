(ns newsfront.dev-server
    (:require [clojure.java.io :as io]
              [compojure.core :refer [ANY defroutes]]
              [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))
  
(defroutes routes
  (ANY "*" _
    {:status 200
      :headers {"Content-Type" "text/html; charset=utf-8"}
      :body (io/input-stream (io/resource "public/index.html"))}))

(def http-handler
  (-> routes
      (wrap-defaults site-defaults)))