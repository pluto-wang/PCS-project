# Personal Communication Service(PCS) project -- Surprise for Friend 

Motivation

People usually delivered festive blessing by sending short message in the past.
However just sending word is so boring , so we want to change our friends wallpaper of cellphone and make they surprised.
The changing type of the wallpaper is based on the different festival.

Architecture

For Sender
  Sender’s UI (get topic and type the receiver’s phone number) 
  Send SMS to Receiver

For Receiver
  When receiver receives the SMS and then parses content and calls the APP (SMS content →  {topic:xxxx} )
  APP searches Image and changes wallpape

Future Work
1. Increase more topic of wallpapers.
2. More wallpapers can select and there are stored in cloud.
3. choose your own photo on your cellphone.
