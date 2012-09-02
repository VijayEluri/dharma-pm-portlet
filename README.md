# The Dharma Overground Private Messaging Portlet

## Background

This is a fork of a MIT/LGPL licensed project that doesn't currently have a repository to live in.

The original project was sponsored by David Ingram, who made it available to the public in several versions here:

http://www.liferay.com/community/forums/-/message_boards/message/1118750

David should be considered the owner of this project, you can contact him via the Liferay message boards.

NOTE:  The Liferay Plugins repository now contains a Private Messaging Portlet
developed by Liferay for Social Office.  You will likely find that portlet to be
better/more reliable than this one.  For certain, it is more actively maintained
than this one.

## Changes from David's original project

This version has been modified from the most recent war file David posted on liferay.com:

1. Builds now for Liferay CE 6.1.1 GA2.  Untested in EE, but should work in 6.1 EE.

2. The check for whether the user has agreed to the terms of service has been commented out.

3. The hard-coded email message headers have been changed, and a mechanism to set them via portal-ext.properties created.

The properties and their defaults are:

dharma.pm.fromaddress="admin@example.com"
dharma.pm.fromname="Portal Administrator"
dharma.pm.mailsubject="New personal message available on portal."

## Building

As usual, the process for building this is:

1. Place the project directory in your Liferay Plugins SDK.

2. ``ant build-service``  (This is optional as the repository now contains the service jar)  
3. ``ant war``  or ``ant deploy``



