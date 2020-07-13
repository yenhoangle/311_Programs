#include <iostream>
using namespace std;
//C++ program to implement a singly linked list, enables inserting integers into the list.
struct Node {
    int data;
    Node *next;
};

class LinkedList {
private:
    Node *head, *tail;

public:
    //constructor
    LinkedList() {
        head = NULL;
        tail = NULL;
    }

    void insert(int n) {
        Node *tmp = new Node;
        tmp->data = n;
        tmp->next = NULL;
        //update head if head is empty
        if (head == NULL)
        {
            head = tmp;
            tail = tmp;
        }
        //update tail if there's already a head
        else
        {
            tail->next = tmp;
            tail = tail->next;
        }
    }
    void printList() {
        cout << "List Items: ";
        for (; head; head = head->next) {
            cout << head->data << " ";
        }
    }
};

int main() {
    LinkedList list;
    int count;
    cout << "Enter how many numbers to insert into the list: ";
    cin >> count;
    int data;
    for(int i = 0; i < count; i++) {
        cout << "Enter number to insert into the list: ";
        cin >> data;
        list.insert(data);
    }
    cout << "Done inserting! Printing list..." << endl;
    list.printList();
    return 0;
}