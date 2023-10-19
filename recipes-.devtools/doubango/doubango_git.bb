DESCRIPTION = "A Fork of the Doubango 3GPP IMS implementation"
HOMEPAGE = "https://github.com/madscientist42/doubango"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://Licensing.md;md5=30f1fe3b9d227ca76fe5efe11f37cb68"

inherit autotools-brokensep pkgconfig


# FIXME!!
#
# Current missing functionality is SRTP and OpenH264- all supports have
# bitrot going on due to drift in codebases on upstream.  We're not going to go
# and use OLD crap in the implementations here for PHA Linux- we've forked it
# to go do versioning right, so in for a penny, in for a pound.  We'll fix this
# over time along with the silly build system if needed

DEPENDS = " \
    alsa-lib \
    libgsm \
    openssl \
    libogg \
    libtheora \
    libvorbis \
    libopus \
    speex \
    libvpx \
    opencore-amr \
    libsrtp \
    libilbc \
    "

RDEPENDS_${PN} = " \
    alsa-lib \
    openssl \
    libogg \
    libtheora \
    libvorbis \
    libopus \
    speex \
    libvpx \
    opencore-amr \
    libsrtp \
    libilbc \
    "

SRC_URI = " \
    git://git@github.com/madscientist42/doubango.git;branch=master;protocol=ssh \
    "

# FIXME : We're going to cheat a bit until this fully gells.  There's work to be
#         done against this that entails working with tip of the PHA Technologies
#         fork of the same here.  While we can devtool this, it's cleaner to let
#         it float a bit until we put out a proper release against everything,
#         what osmocom started and didn't finish and PHA's stuffle.
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

# There's *breakage* unless you turn libyuv support or specify it's explicit path.
#
# (Ah, autotools.  So very easy to fubar yourself on a cross-compile situation.)
#
# We're not using the support right now because it's going to take someone fixing
# the stuff they have in hand for checks, etc. as the code has drifted upstream.
#
# That being said, we should be able to bring in the rest of the features properly
# and then properly sort out the libyuv stuff in the build system either by fixing
# the broken crap or replacing all of autotools for CMake or Meson.  We only need
# one or two things turned more properly on/off and we'll have the IMS core for VoLTE
# and VoWIFI.  Maybe even the ViLTE and ViWIFI (Video over...) stuff.  Be nifty
# to have a universal solution that ties back to stuff that allows Teams and Meet
# to work on a target here.
EXTRA_OECONF += " \
    --without-yuv \
    "