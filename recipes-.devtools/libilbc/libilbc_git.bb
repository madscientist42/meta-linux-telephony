DESCRIPTION = "Packaged version of iLBC codec from the WebRTC project"
HOMEPAGE = "https://github.com/TimothyGu/libilbc"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://COPYING;md5="

inherit cmake

DEPENDS = " \
    abseil-cpp \
    "

RDEPENDS_${PN} = " \
    abseil-cpp \
    "

SRC_URI = " \
    git://github.com/TimothyGu/libilbc.git;protocol=https;branch=main \
    file://0001-fix-cmake-for-yocto.patch \
    "

# FIXME : Cheat and grab tip for now.
SRCREV = "6adb26d4a4e159cd66d4b4c5e411cd3de0ab6b5e"
PV = "${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " \
    "


