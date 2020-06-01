StartScroll=find("1590870347114.png")
a=400
while a<800:
    if exists("1590870363047.png"):break
    dragDrop("1590871864728.png", Location(StartScroll.x, StartScroll.y+a))
    a=a+40
click("1590870614961.png")
type("1590870554569.png","Via Fratelli Cervi 22 Bri")
wait(1)
type("n")
wait(1)
type("d")
wait(1)
click("Screenshot 2020-05-30 22.33.04.png")
click("1590870713540.png")
while a<800:
    if exists("1590871079845.png"):break
    dragDrop("1590871864728.png", Location(StartScroll.x, StartScroll.y+a))
    a=a+40
click(Pattern("1590872298817.png").targetOffset(32,-12))
while a<800:
    if exists("1590871976658.png"):break
    dragDrop("1590871864728.png", Location(StartScroll.x, StartScroll.y+a))
    a=a+80
type(Pattern("1590871631883.png").targetOffset(28,-1), "2")
type(Pattern("1590872357230.png").targetOffset(37,-4), "2")
type(Pattern("1590872381054.png").targetOffset(66,-5), "2")
click("1590872026249.png")
find("1590871676015.png")
click("1590871702011.png")
a=400
while a<800:
    if exists("1590870363047.png"):break
    dragDrop("1590871864728.png", Location(StartScroll.x, StartScroll.y+a))
    a=a+40
click("1590870614961.png")
type("1590870554569.png","Via Fratelli Cervi 22 Bri")
wait(1)
type("n")
wait(1)
type("d")
wait(1)
click("Screenshot 2020-05-30 22.33.04.png")
click("1590870713540.png")
while a<800:
    if exists("1590871079845.png"):break
    dragDrop("1590871864728.png", Location(StartScroll.x, StartScroll.y+a))
    a=a+40
find("1590872454809.png")