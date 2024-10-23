#Given a $tagClass and a $country, find all the Forums created in the given $country, containing at
#least one Message with Tags belonging directly to the given $tagClass, and count the Messages by
#the Forum which contains them.
#The location of a Forum is identified by the location of the Forum’s moderator.

?forum :hasModerator ?person
?person :isLocatedIn ?city
?city :isPartOf ?country 
?forum :containerOf ?post
?comment :isReplyOf ?post
?comment :hasTag ?tag
?tag :isA ?tagClass