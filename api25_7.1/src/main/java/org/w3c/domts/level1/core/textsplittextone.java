
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:


Copyright (c) 2001 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University). All
Rights Reserved. This program is distributed under the W3C's Software
Intellectual Property License. This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.
See W3C License http://www.w3.org/Consortium/Legal/ for more details.

*/

package org.w3c.domts.level1.core;

import org.w3c.domts.DOMTestCase;
import org.w3c.domts.DOMTestDocumentBuilderFactory;



/**
 *     The "splitText(offset)" method breaks the Text node into
 *     two Text nodes at the specified offset keeping each node
 *     as siblings in the tree.
 *     
 *     Retrieve the textual data from the second child of the 
 *     third employee and invoke the "splitText(offset)" method.
 *     The method splits the Text node into two new sibling
 *     Text nodes keeping both of them in the tree.   This test
 *     checks the "nextSibling()" method of the original node
 *     to ensure that the two nodes are indeed siblings.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D</a>
*/
public final class textsplittextone extends DOMTestCase {

   /**
    * Constructor.
    * @param factory document factory, may not be null
    * @throws org.w3c.domts.DOMTestIncompatibleException Thrown if test is not compatible with parser configuration
    */
   public textsplittextone(final DOMTestDocumentBuilderFactory factory)  throws org.w3c.domts.DOMTestIncompatibleException {
      super(factory);

    //
    //   check if loaded documents are supported for content type
    //
    String contentType = getContentType();
    preload(contentType, "staff", true);
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void runTest() throws Throwable {
      Document doc;
      NodeList elementList;
      Node nameNode;
      Text textNode;
      Text splitNode;
      Node secondPart;
      String value;
      doc = (Document) load("staff", true);
      elementList = doc.getElementsByTagName("name");
      nameNode = elementList.item(2);
      textNode = (Text) nameNode.getFirstChild();
      splitNode = textNode.splitText(7);
      secondPart = textNode.getNextSibling();
      value = secondPart.getNodeValue();
      assertEquals("textSplitTextOneAssert", "Jones", value);
      }
   /**
    *  Gets URI that identifies the test.
    *  @return uri identifier of test
    */
   public String getTargetURI() {
      return "http://www.w3.org/2001/DOM-Test-Suite/level1/core/textsplittextone";
   }
   /**
    * Runs this test from the command line.
    * @param args command line arguments
    */
   public static void main(final String[] args) {
        DOMTestCase.doMain(textsplittextone.class, args);
   }
}

