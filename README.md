BaSliGC
=======

Basic Slick2d Game Components
-----------------------------

BaSliGC is library which provides game components for game programmed with Slick2D.


Components
-----------

There are basic components like :

* Characters
* Buttons 
* Images

These Components are managed by the ComponetList class. So it's  only needed to created the specific object add it to the list and at the list in the render method.

```java

    button = new Button();
    gamecomponentlist.addComponent(button);

    public void render(){
    gamecomponentlist.draw();        
    }


```


Functions
---------

These basic components could be (or are) decorated with a few useful functions:

* Clickable
* Dragable
* Solid (Characters can't walk through them)






