package extensions.java.lang.String;

import manifold.ext.api.Extension;
import manifold.ext.api.This;
import manifold.util.CharPredicate;

/**
 * Adapted from kotlin.text.String
 */
@Extension
public class ManStringExt
{
  /**
   * Returns a string with leading and trailing characters matching the [predicate] trimmed.
   */
  public static String trim( @This String thiz, CharPredicate predicate )
  {
    return ((CharSequence)thiz).trim( predicate ).toString();
  }

  /**
   * Returns a string with leading characters matching the [predicate] trimmed.
   */
  public static String trimStart( @This String thiz, CharPredicate predicate )
  {
    return ((CharSequence)thiz).trimStart( predicate ).toString();
  }

  /**
   * Returns a string with trailing characters matching the [predicate] trimmed.
   */
  public static String trimEnd( @This String thiz, CharPredicate predicate )
  {
    return ((CharSequence)thiz).trimEnd( predicate ).toString();
  }

  /**
   * Returns a string with leading and trailing characters from the [chars] array trimmed.
   */
  public static String trim( @This String thiz, char... chars )
  {
    return thiz.trim( it ->
                      {
                        for( int i = 0; i < chars.length; i++ )
                        {
                          char c = chars[i];
                          if( c == it )
                          {
                            return true;
                          }
                        }
                        return false;
                      } );
  }

  /**
   * Returns a string with leading and trailing characters from the [chars] array trimmed.
   */
  public static String trimStart( @This String thiz, char... chars )
  {
    return thiz.trimStart( it ->
                           {
                             for( int i = 0; i < chars.length; i++ )
                             {
                               char c = chars[i];
                               if( c == it )
                               {
                                 return true;
                               }
                             }
                             return false;
                           } );
  }

  /**
   * Returns a string with trailing characters from the [chars] array trimmed.
   */
  public static String trimEnd( @This String thiz, char... chars )
  {
    return thiz.trimEnd( it ->
                         {
                           for( int i = 0; i < chars.length; i++ )
                           {
                             char c = chars[i];
                             if( c == it )
                             {
                               return true;
                             }
                           }
                           return false;
                         } );
  }

  /**
   * Returns a string with leading whitespace removed.
   */
  public static String trimStart( @This String thiz )
  {
    return ((CharSequence)thiz).trimStart().toString();
  }

  /**
   * Returns a string with trailing whitespace removed.
   */
  public static String trimEnd( @This String thiz )
  {
    return ((CharSequence)thiz).trimEnd().toString();
  }

  /**
   * Pads the string to the specified [length] at the beginning with the specified character or space.
   *
   * @param length  the desired string length.
   * @param padChar the character to pad string with, if it has length less than the [length] specified.
   *
   * @returns Returns a string, of length at least [length], consisting of string prepended with [padChar] as many times.
   * as are necessary to reach that length.
   */
  public static String padStart( @This String thiz, int length, char padChar )
  {
    return ((CharSequence)thiz).padStart( length, padChar ).toString();
  }

  /**
   * Pads the string to the specified [length] at the end with the specified character or space.
   *
   * @param length  the desired string length.
   * @param padChar the character to pad string with, if it has length less than the [length] specified.
   *
   * @returns Returns a string, of length at least [length], consisting of string prepended with [padChar] as many times.
   * as are necessary to reach that length.
   */
  public static String padEnd( @This String thiz, int length, char padChar )
  {
    return ((CharSequence)thiz).padEnd( length, padChar ).toString();
  }

  /**
   * Returns the string if it is not null, or the empty string otherwise.
   */
  public static String emptyIfNull( @This String thiz )
  {
    return thiz == null ? "" : thiz;
  }

  /**
   * Returns a substring before the first occurrence of [delimiter] or null if the string
   * does not contain the delimiter
   */
  public static String substringBefore( @This String thiz, char delimiter )
  {
    int index = thiz.indexOf( delimiter );
    return (index == -1) ? null : thiz.substring( 0, index );
  }

  /**
   * Returns a substring before the first occurrence of [delimiter] or null if the string
   * does not contain the delimiter
   */
  public static String substringBefore( @This String thiz, String delimiter )
  {
    int index = thiz.indexOf( delimiter );
    return (index == -1) ? null : thiz.substring( 0, index );
  }

  /**
   * Returns a substring after the first occurrence of [delimiter] or null if the string
   * does not contain the delimiter
   */
  public static String substringAfter( @This String thiz, char delimiter )
  {
    int index = thiz.indexOf( delimiter );
    return (index == -1) ? null : thiz.substring( index + 1, thiz.length() );
  }

  /**
   * Returns a substring after the first occurrence of [delimiter] or null if the string
   * does not contain the delimiter
   */
  public static String substringAfter( @This String thiz, String delimiter )
  {
    int index = thiz.indexOf( delimiter );
    return (index == -1) ? null : thiz.substring( index + delimiter.length(), thiz.length() );
  }

  /**
   * Returns a substring before the last occurrence of [delimiter] or null if the string
   * does not contain the delimiter
   */
  public static String substringBeforeLast( @This String thiz, char delimiter )
  {
    int index = thiz.lastIndexOf( delimiter );
    return index == -1 ? null : thiz.substring( 0, index );
  }

  /**
   * Returns a substring before the last occurrence of [delimiter] or null if the string
   * does not contain the delimiter
   */
  public static String substringBeforeLast( @This String thiz, String delimiter )
  {
    int index = thiz.lastIndexOf( delimiter );
    return index == -1 ? null : thiz.substring( 0, index );
  }

  /**
   * Returns a substring after the last occurrence of delimiter or null if the string
   * does not contain the delimiter
   */
  public static String substringAfterLast( @This String thiz, char delimiter )
  {
    int index = thiz.lastIndexOf( delimiter );
    return index == -1 ? null : thiz.substring( index + 1, thiz.length() );
  }

  /**
   * Returns a substring after the last occurrence of delimiter or null if the string
   * does not contain the delimiter
   */
  public static String substringAfterLast( @This String thiz, String delimiter )
  {
    int index = thiz.lastIndexOf( delimiter );
    return (index == -1) ? null : thiz.substring( index + delimiter.length(), thiz.length() );
  }

  /**
   * If thiz string starts with the given [prefix], returns a copy of thiz string
   * with the prefix removed. Otherwise, returns thiz string.
   */
  public static String removePrefix( @This String thiz, CharSequence prefix )
  {
    if( thiz.startsWith( prefix ) )
    {
      return thiz.substring( prefix.length() );
    }
    return thiz;
  }

  /**
   * If thiz string ends with the given [suffix], returns a copy of thiz string
   * with the suffix removed. Otherwise, returns thiz string.
   */
  public static String removeSuffix( @This String thiz, CharSequence suffix )
  {
    if( thiz.endsWith( suffix ) )
    {
      return thiz.substring( 0, thiz.length() - suffix.length() );
    }
    return thiz;
  }

  /**
   * Removes from a string both the given [prefix] and [suffix] if and only if
   * it starts with the [prefix] and ends with the [suffix].
   * Otherwise returns thiz string unchanged.
   */
  public static String removeSurrounding( @This String thiz, CharSequence prefix, CharSequence suffix )
  {
    if( (thiz.length() >= prefix.length() + suffix.length()) && thiz.startsWith( prefix ) && thiz.endsWith( suffix ) )
    {
      return thiz.substring( prefix.length(), thiz.length() - suffix.length() );
    }
    return thiz;
  }

  /**
   * Removes the given [delimiter] string from both the start and the end of thiz string
   * if and only if it starts with and ends with the [delimiter].
   * Otherwise returns thiz string unchanged.
   */
  public static CharSequence removeSurrounding( @This String thiz, CharSequence delimiter )
  {
    return thiz.removeSurrounding( delimiter, delimiter );
  }
}
