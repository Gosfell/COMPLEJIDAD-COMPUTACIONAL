package sistemabus;
/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian_Carrasco-Claudio
 */

// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
class Link
{
   public Pasaje dData;                // data item
   public Link next;                 // next link in list
   // -------------------------------------------------------------
   public Link(Pasaje d)               // constructor
   { dData = d; }
   // -------------------------------------------------------------
   public void displayLink()         // display this link
   { System.out.print("Pasajero: "+dData.getNombrePasajero()+" | ID: "+dData.getId() +" ;"); }
// -------------------------------------------------------------
}  // end class Link
////////////////////////////////////////////////////////////////
class FirstLastList
{
   private Link first;               // ref to first item
   private Link last;                // ref to last item
   // -------------------------------------------------------------
   public FirstLastList()            // constructor
   {
      first = null;                  // no items on list yet
      last = null;
   }
   // -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
   { return first==null; }
   // -------------------------------------------------------------
   public void insertLast(Pasaje dd) // insert at end of list
   {
      Link newLink = new Link(dd);   // make new link
      if( isEmpty() )                // if empty list,
         first = newLink;            // first --> newLink
      else
         last.next = newLink;        // old last --> newLink
      last = newLink;                // newLink <-- last
   }
   // -------------------------------------------------------------
   public Pasaje deleteFirst()         // delete first link
   {                              // (assumes non-empty list)
      Pasaje temp = first.dData;
      if(first.next == null)         // if only one item
         last = null;                // null <-- last
      first = first.next;            // first --> old next
      return temp;
   }
   // -------------------------------------------------------------
   public void displayList()
   {
      Link current = first;          // start at beginning
      while(current != null)         // until end of list,
      {
         current.displayLink();      // print data
         current = current.next;     // move to next link
      }
      System.out.println("");
   }

   public int size()
   {
      int acc=0;
      Link current = first;          // start at beginning
      while(current != null)         // until end of list,
      {
         acc++;     // print data
         current = current.next;     // move to next link
      }
      return acc;
   }
// -------------------------------------------------------------
}  // end class FirstLastList
////////////////////////////////////////////////////////////////
class LinkQueue
{
   private FirstLastList theList;
   //--------------------------------------------------------------
   public LinkQueue()                // constructor
   { theList = new FirstLastList(); }  // make a 2-ended list
   //--------------------------------------------------------------
   public boolean isEmpty()          // true if queue is empty
   { return theList.isEmpty(); }
   //--------------------------------------------------------------
   public void insert(Pasaje j)        // insert, rear of queue
   { theList.insertLast(j); }
   //--------------------------------------------------------------
   public Pasaje remove()              // remove, front of queue
   {  return theList.deleteFirst();  }
   //--------------------------------------------------------------
   public void displayQueue()
   {
      System.out.print("Cola (Primero-->Ultimo): ");
      theList.displayList();
   }

   public int size()
   {
      return theList.size();
   }
//--------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////


