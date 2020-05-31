click("1590946934801.png")
for i in range(100):
    type(Key.DOWN)
    if exists(Pattern("1590947586071.png").similar(0.90)):
        break

for i in range(100):
    type(Key.DOWN)
    if exists(Pattern("1590948409147.png").similar(0.90)):
        break

type("1590947653853.png", "Gas Station name")
type("1590947683516.png", "Viale Svezia Collegno Piemont Italy")
wait(3)
type(Key.DOWN)
type(Key.ENTER)
wait(2)
click("1590947928711.png")
type(Key.DOWN)
type(Key.DOWN)
type(Key.ENTER)
click("1590948010297.png")
click("1590948037823.png")
click("1590948689571.png")
for i in range(100):
    type(Key.UP)
    if exists("1590959435493.png"):
        break
click("1590959435493.png")
wait(3)
for i in range(100):
    type(Key.DOWN)
    if exists("1590959541151.png"):
        break
type("1590959587973.png", "Viale Svezia Collegno Piemont Italy")
wait(2)
type(Key.DOWN)
type(Key.ENTER)
click("1590959732535.png")
for i in range(10):
    type(Key.DOWN)
    if exists("1590960098907.png"):
        break
find("1590959763811.png")