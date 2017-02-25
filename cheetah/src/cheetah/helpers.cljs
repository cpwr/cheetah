(ns cheetah.helpers)

(defn avatar-url [username]
  (get
    {
     "anxolerd" "http://0.gravatar.com/avatar/25831f72976cbc7a02cf192729c7dc7b"
     "rich"     "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/3/000/024/157/2fd1a24.jpg"
     "david"    "https://2013.webrebels.org/gfx/speaker_david.jpg"
     "ben"      "http://i.imgur.com/1rm5Qq6.png"}

    username
    "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/3/000/024/157/2fd1a24.jpg"))

; stub
(defn owner? [username] (= username "ben"))

; stub
(defn get-chat-messages [chat]
  [["rich" "How did you do that"]
   ["david" "Dude! Why the hell you asked?"]
   ["ben" "... Because I am Batman!"]
   ["anxolerd" "and now we all know your secret identity xD"]
   ["ben" "Doh =("]])
