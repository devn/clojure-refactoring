(ns clojure_refactoring.rename_fn
  (:use clojure.walk))

(defn z [a] (+ a 1))
(def y 1)
(defn try-out-mocking [a] (z a y))

(defn rename-fn [fn-string old-name-as-string new-name-as-string]
  (let [node (read-string fn-string)
        new-name (symbol new-name-as-string)]
    (str
     (postwalk-replace
      {(second node) new-name} node))))
