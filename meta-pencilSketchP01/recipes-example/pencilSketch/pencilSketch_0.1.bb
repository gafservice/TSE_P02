SUMMARY = "PencilSketch recipe"
DESCRIPTION = "Procesa una imagen y da como resultado la imagen dibujada a mano"
LICENSE = "CLOSED"

SRC_URI = "file://pencilSketch.py \
	   file://me.jpg \
	   file://villageRoad.jpg"
	
S = "${WORKDIR}"

do_install(){
    install -d ${D}${bindir}
    install -m 0755 pencilSketch.py ${D}${bindir}
    
    install -d ${D}${bindir}
    install -m 0755 me.jpg ${D}${bindir}
    
    install -d ${D}${bindir}
    install -m 0755 villageRoad.jpg ${D}${bindir}
}
pkg_postinst_ontarget_pencilSketch(){
	#!/bin/sh
	python3 /usr/bin/pencilSketch.py
	sleep 5
	poweroff
}
