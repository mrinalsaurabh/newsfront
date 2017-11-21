(ns newsfront.core
  (:require [reagent.core :as reagent]
            [goog.events :as events]
            [newsfront.route-events]
            [goog.history.EventType :as EventType]
            [re-frame.core :refer [dispatch]]
            [re-frame.core :as re-frame])
  (:import goog.history.Html5History                                                                                                                         
    goog.Uri))

(enable-console-print!)

(defn current-component [text]
  [:div {} (str "url: " text)])

(defn ^:export init []
  (let [url (.. js/window
                -location
                -href)]
    (dispatch [:current-url url])
    (reagent/render-component [current-component url] (.getElementById js/document "app"))))

(defn hook-browser-navigation! [] 
  (let [history (doto (Html5History.) 
                      (events/listen
                      EventType/NAVIGATE 
                      (fn [event]
                        (dispatch [:current-url (.-token event)])))
                      (.setUseFragment false) 
                      (.setPathPrefix "") 
                      (.setEnabled true)) 
        url (.. js/window 
                -location
                -href)]
    (events/listen js/document "click"
    (fn [e]
      (let [path (.getPath (.parse Uri (.-href (.-target e)))) 
      title (.-title (.-target e))])))))

;; need to run this after routes have been defined
(hook-browser-navigation!)