(ns dnsrelation.core
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.cypher :as cy]))

(def conn  (nr/connect "http://localhost:7474/db/data/"))

(defn search-repeat
  [dns index]
  (let [result (nn/query conn index (str index ":" dns))]
    (if (empty? result)
      nil
      (:id ((into [] result) 1))
    )
  ))

(defn -main
  [& args]
  ;; creates a node wit two properties
  (print (search-repeat "jo22e" "by-username"))
  )