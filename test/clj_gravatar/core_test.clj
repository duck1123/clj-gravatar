(ns clj-gravatar.core-test
  (:require [clj-gravatar.core :refer :all]
            [midje.sweet :refer :all]))

; http://ja.gravatar.com/site/implement/profiles/json/
(def ^:dynamic *test-address* "beau@dentedreality.com.au")

(facts "map->get-parameter"
  (map->get-parameter {}) => nil?
  (map->get-parameter {:a 1}) => "?a=1"
  (map->get-parameter {:a 1 :b nil}) => "?a=1"
  (map->get-parameter {:a 1 :b 2}) => "?b=2&a=1"
  (map->get-parameter {:a 1 :b 2 :c nil}) => "?b=2&a=1"
  (map->get-parameter {:s "http://hoge.com/"}) => "?s=http%3A%2F%2Fhoge.com%2F")

(facts "gravatar-image"
  (gravatar-image *test-address*) =>
  "http://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50"

  (gravatar-image *test-address* :secure? true) =>
  "https://secure.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50")

(facts "gravatar-profile"
  (gravatar-profile "NOTFOUNDUSER") => nil?
  (gravatar-profile *test-address*) =>
  (contains
   {:entry (contains
            (contains {:id "1428"
                       :requestHash "205e460b479e2e5b48aec07710c08d50"
                       :emails (contains
                                (contains {:value *test-address*}))}))}))
