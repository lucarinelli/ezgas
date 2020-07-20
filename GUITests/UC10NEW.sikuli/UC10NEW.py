StartScroll=find("1590870347114.png")
a=400
while a<800:
    if exists("1593010238019.png"):break
    dragDrop("1590870380358.png", Location(StartScroll.x, StartScroll.y+a))
    a=a+40
click("1590870614961.png")
type("1590870554569.png","Via Fratelli Cervi 22 Bri")
wait(1)
type("n")
wait(1)
type("d")
wait(1)
click("Screenshot 2020-05-30 22.33.04.png")
type(Pattern("1593010270252.png").targetOffset(83,-3),"2")
click("1590870713540.png")
while a<800:
    if exists("1590871079845.png"):break
    dragDrop("1590870380358.png", Location(StartScroll.x, StartScroll.y+a))
    a=a+40
click("1590871311973.png")
find("1590871337290.png")
click("1590871349702.png")
find("1590871401067.png")