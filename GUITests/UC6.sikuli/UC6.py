RegionScroll = find("1590850440994.png").nearby()
StartScrollBar=RegionScroll.find(Pattern("1590836957754.png").targetOffset(-1,3))
a=150;
while a<600:
    if exists(Pattern("1590849539057.png").similar(0.40)):break    
    dragDrop("1590846497444.png", Location(StartScrollBar.x, StartScrollBar.y+a))
    # type(Key.DOWN)
    # type(Key.DOWN) #dragDrop go up and down
    # type(Key.DOWN)
    a=a+20
RegionForm=find(Pattern("1590849539057.png").similar(0.40)).nearby(5)

RegionForm.click("1590854159951.png")
RegionForm.click(Pattern("1590837582862.png").similar(0.50).targetOffset(-173,-72))
type("pollo")
RegionForm.click(Pattern("1590837816749.png").similar(0.50).targetOffset(-126,77))
CarSharing=RegionForm.find(Pattern("1590838396788.png").similar(0.50).targetOffset(69,-2))
click(Location(CarSharing.x+200, CarSharing.y+54))#Enjoy
RegionForm.click(Pattern("1590837582862.png").similar(0.50).targetOffset(-204,-26))
type("Corso Duca dei Polli")
RegionForm.click(Pattern("1590837582862.png").similar(0.50).targetOffset(-336,-12))
RegionForm.click(Pattern("1590837582862.png").similar(0.50).targetOffset(-197,65))
type("9.7271583")
RegionForm.click(Pattern("1590837582862.png").similar(0.50).targetOffset(-200,20))
type("45.6082454")
RegionForm.click(Pattern("1590838541438.png").similar(0.50).targetOffset(-341,40))
RegionForm.click("1590854187479.png")
a=250;
while a<800:
    if exists(Pattern("1590850705638.png").similar(0.60)):break    #just to be portable
    dragDrop("1590846497444.png", Location(StartScrollBar.x, StartScrollBar.y+a))
    # type(Key.DOWN)
    # type(Key.DOWN)
    # type(Key.DOWN)
    a=a+20
deleteRegion=find(Pattern("1590852190159.png").similar(0.80))
deleteRegion.click("1590853669425.png")
    
not find(Pattern("1590852190159.png").similar(0.80))