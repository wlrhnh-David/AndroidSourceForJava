
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001 World Wide Web Consortium, 
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All 
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the 
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
PURPOSE.  

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package org.w3c.domts.level2.core;

import org.w3c.domts.DOMTestCase;
import org.w3c.domts.DOMTestDocumentBuilderFactory;



/**
 *  The importNode method imports a node from another document to this document. 
 *  The returned node has no parent; (parentNode is null). The source node is not 
 *  altered or removed from the original document but a new copy of the source node
 *  is created.
 *  
 *  Using the method importNode with deep=true, import a entity node ent4 
 *  from this document to a new document object.  The replacement text of this entity is an element
 *  node, a cdata node and a pi.  Verify if the nodes have been 
 *  imported correctly by checking the nodeNames of the imported element node, the data for the
 *  cdata nodes and the PItarget and PIData for the pi nodes.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
public final class documentimportnode20 extends DOMTestCase {

   /**
    * Constructor.
    * @param factory document factory, may not be null
    * @throws org.w3c.domts.DOMTestIncompatibleException Thrown if test is not compatible with parser configuration
    */
   public documentimportnode20(final DOMTestDocumentBuilderFactory factory)  throws org.w3c.domts.DOMTestIncompatibleException {

      org.w3c.domts.DocumentBuilderSetting[] settings = 
          new org.w3c.domts.DocumentBuilderSetting[] {
org.w3c.domts.DocumentBuilderSetting.namespaceAware,
org.w3c.domts.DocumentBuilderSetting.notExpandEntityReferences
        };
        DOMTestDocumentBuilderFactory testFactory = factory.newInstance(settings);
        setFactory(testFactory);

    //
    //   check if loaded documents are supported for content type
    //
    String contentType = getContentType();
    preload(contentType, "staffNS", true);
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void runTest() throws Throwable {
      Document doc;
      Document docImp;
      DOMImplementation domImpl;
      DocumentType docType;
      DocumentType docTypeNull = null;

      NamedNodeMap nodeMap;
      Entity entity4;
      Entity entityImp4;
      Element element;
      CharacterData cdata;
      ProcessingInstruction pi;
      NodeList childList;
      NodeList elemchildList;
      String ent4Name;
      String ent4ImpName;
      String cdataVal;
      String piTargetVal;
      String piDataVal;
      doc = (Document) load("staffNS", true);
      domImpl = doc.getImplementation();
      docType = doc.getDoctype();
      docImp = domImpl.createDocument("http://www.w3.org/DOM/Test", "a:b", docTypeNull);
      nodeMap = docType.getEntities();
      entity4 = (Entity) nodeMap.getNamedItem("ent4");
      entityImp4 = (Entity) docImp.importNode(entity4, true);
      childList = entityImp4.getChildNodes();
      element = (Element) childList.item(0);
      elemchildList = element.getChildNodes();
      cdata = (CharacterData) elemchildList.item(0);
      pi = (ProcessingInstruction) childList.item(1);
      ent4Name = entity4.getNodeName();
      ent4ImpName = entityImp4.getNodeName();
      cdataVal = cdata.getData();
      piTargetVal = pi.getTarget();
      piDataVal = pi.getData();
      assertEquals("documentimportnode20_Ent4NodeName", ent4Name, ent4ImpName);
      assertEquals("documentimportnode20_Cdata", "Element data", cdataVal);
      assertEquals("documentimportnode20_PITarget", "PItarget", piTargetVal);
      assertEquals("documentimportnode20_PIData", "PIdata", piDataVal);
      }
   /**
    *  Gets URI that identifies the test.
    *  @return uri identifier of test
    */
   public String getTargetURI() {
      return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentimportnode20";
   }
   /**
    * Runs this test from the command line.
    * @param args command line arguments
    */
   public static void main(final String[] args) {
        DOMTestCase.doMain(documentimportnode20.class, args);
   }
}

