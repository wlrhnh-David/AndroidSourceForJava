
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:


Copyright (c) 2001-2004 World Wide Web Consortium,
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
 * The "getAttributes()" method invoked on a CDATASection
 * Node returns null.
 * Retrieve the CDATASection node contained inside the
 * second child of the second employee and invoke the
 * "getAttributes()" method on the CDATASection node.
 * It should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212</a>
*/
public final class nodecdatasectionnodeattribute extends DOMTestCase {

   /**
    * Constructor.
    * @param factory document factory, may not be null
    * @throws org.w3c.domts.DOMTestIncompatibleException Thrown if test is not compatible with parser configuration
    */
   public nodecdatasectionnodeattribute(final DOMTestDocumentBuilderFactory factory)  throws org.w3c.domts.DOMTestIncompatibleException {
      super(factory);

    //
    //   check if loaded documents are supported for content type
    //
    String contentType = getContentType();
    preload(contentType, "staff", false);
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void runTest() throws Throwable {
      Document doc;
      NodeList elementList;
      Element cdataName;
      Node cdataNode;
      NamedNodeMap attrList;
      int nodeType;
      doc = (Document) load("staff", false);
      elementList = doc.getElementsByTagName("name");
      cdataName = (Element) elementList.item(1);
      cdataNode = cdataName.getLastChild();
      nodeType = (int) cdataNode.getNodeType();
      
      if (!equals(4, nodeType)) {
          cdataNode = doc.createCDATASection("");
      }
    attrList = cdataNode.getAttributes();
      assertNull("cdataSection", attrList);
      }
   /**
    *  Gets URI that identifies the test.
    *  @return uri identifier of test
    */
   public String getTargetURI() {
      return "http://www.w3.org/2001/DOM-Test-Suite/level1/core/nodecdatasectionnodeattribute";
   }
   /**
    * Runs this test from the command line.
    * @param args command line arguments
    */
   public static void main(final String[] args) {
        DOMTestCase.doMain(nodecdatasectionnodeattribute.class, args);
   }
}

