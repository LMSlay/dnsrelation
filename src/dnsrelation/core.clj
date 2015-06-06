(ns dnsrelation.core
  (:require [dnsrelation.core.database :as db]
            [load as ld]))

(defn tests
  [& args]
  ;; creates a node wit two properties
  (ld/data-load (ld/path 0) ld/dns-deal-test)
  )