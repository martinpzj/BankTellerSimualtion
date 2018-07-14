#------------------------------------------------------------------------------
#Makefile for BankTellerSimulation
#------------------------------------------------------------------------------
JAVASRC = Main.java Queue.java Node.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = Main
CLASSES = Main.class Queue.class Node.class
JARFILE = BankTeller.jar
all: $(JARFILE)
$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)
clean:
	rm $(CLASSES) $(JARFILE)
