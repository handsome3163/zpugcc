/* GtkFontPeer.java -- Implements FontPeer with GTK+
   Copyright (C) 1999 Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
02111-1307 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */


package gnu.java.awt.peer.gtk;
import java.awt.peer.FontPeer;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.text.*;
import gnu.java.awt.peer.ClasspathFontPeer;

public class GtkFontPeer extends ClasspathFontPeer
{
  private static ResourceBundle bundle;
  
  static
  {
    try
      {
	bundle = ResourceBundle.getBundle ("gnu.java.awt.peer.gtk.font");
      }
    catch (Throwable ignored)
      {
	bundle = null;
      }
  }

  final private String Xname; // uses %d for font size.

  public GtkFontPeer (String name, int style)
  {
    super(name, style, 12 /* kludge */);

    if (bundle != null)
      Xname = bundle.getString (name.toLowerCase () + "." + style);
    else
      {
	String weight;
	String slant;
	String spacing;

	if (style == Font.ITALIC || (style == (Font.BOLD+Font.ITALIC)))
	  slant = "i";
	else
	  slant = "r";
	if (style == Font.BOLD || (style == (Font.BOLD+Font.ITALIC)))
	  weight = "bold";
	else
	  weight = "medium";
	if (name.equals("Serif") || name.equals("SansSerif")
	    || name.equals("Helvetica") || name.equals("Times"))
	  spacing = "p";
	else
	  spacing = "c";

        Xname = "-*-*-" + weight + "-" + slant + "-normal-*-%d-*-*-*-" + spacing + "-*-*-*";
      }
  }

  public String getXLFD ()
  {
    return Xname;
  }


  /* remaining methods are for static compatibility with the newer
     ClasspathFontPeer superclass; none of these methods ever existed or
     worked on the older FontPeer interface, but we need to pretend to
     support them anyways. */

  public boolean canDisplay (Font font, char c)
  {
    throw new UnsupportedOperationException();
  }

  public int canDisplayUpTo (Font font, CharacterIterator i, int start, int limit)
  {
    throw new UnsupportedOperationException();
  }

  public String getSubFamilyName (Font font, Locale locale)
  {
    throw new UnsupportedOperationException();
  }

  public String getPostScriptName (Font font)
  {
    throw new UnsupportedOperationException();
  }

  public int getNumGlyphs (Font font)
  {
    throw new UnsupportedOperationException();
  }

  public int getMissingGlyphCode (Font font)
  {
    throw new UnsupportedOperationException();
  }

  public byte getBaselineFor (Font font, char c)
  {
    throw new UnsupportedOperationException();
  }

  public String getGlyphName (Font font, int glyphIndex)
  {
    throw new UnsupportedOperationException();
  }

  public GlyphVector createGlyphVector (Font font,
                                                 FontRenderContext frc,
                                                 CharacterIterator ci)
  {
    throw new UnsupportedOperationException();
  }

  public GlyphVector createGlyphVector (Font font, 
                                                 FontRenderContext ctx, 
                                                 int[] glyphCodes)
  {
    throw new UnsupportedOperationException();
  }

  public GlyphVector layoutGlyphVector (Font font, 
                                                 FontRenderContext frc, 
                                                 char[] chars, int start, 
                                                 int limit, int flags)
  {
    throw new UnsupportedOperationException();
  }

  public FontMetrics getFontMetrics (Font font)
  {
    throw new UnsupportedOperationException();
  }

  public boolean hasUniformLineMetrics (Font font)
  {
    throw new UnsupportedOperationException();
  }

  public LineMetrics getLineMetrics (Font font, 
                                              CharacterIterator ci, 
                                              int begin, int limit, 
                                              FontRenderContext rc)
  {
    throw new UnsupportedOperationException();
  }

  public Rectangle2D getMaxCharBounds (Font font, 
                                                FontRenderContext rc)
  {
    throw new UnsupportedOperationException();
  }

  public Rectangle2D getStringBounds (Font font, 
                                               CharacterIterator ci, 
                                               int begin, int limit, 
                                               FontRenderContext frc)
  {
    throw new UnsupportedOperationException();
  }
}
