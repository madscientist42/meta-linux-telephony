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

# FIXME : Cheat and autorev this for now.  Will fix with a versioned hash
#         shortly so we have a clean answer for this going forward.
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " \
    "


