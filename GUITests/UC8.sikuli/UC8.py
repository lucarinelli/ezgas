StartScroll=find("1590870347114.png")
a=400
while a<800:
    if exists("1590870363047.png"):break
    dragDrop("1590871864728.png", Location(StartScroll.x, StartScroll.y+a))
    a=a+40
type("proximity.png","Via Oddino Morgari")
wait(4)
type(Key.DOWN + Key.ENTER)
click("search.png")
type(Key.DOWN + Key.ENTER)
click("typeOfcarSharing.png")
type(Key.DOWN + Key.ENTER)
click("typeOfGasoline.png")
