#include <iostream>
//#include <conio.h>

using namespace std;

int main()
{
	int chicken,hen,cock;
	cout<<"100����100ֻ�����⡣chicken 1��3ֻ��hen 3��1ֻ��cock 5��1ֻ"<<endl;
	cout<<"chicken\t"<<"hen\t"<<"cock"<<endl;
	for(chicken=0;chicken<=100;chicken+=3)
		for(hen=0;hen<=33;hen++)
			if((cock=100-chicken-hen)>-1)
				if((chicken/3+hen*3+cock*5)==100)
					cout<<chicken<<"\t"<<hen<<"\t"<<cock<<endl;
	cout<<"Press any key to exit! "<<endl;
	//getch();
	return 0;
}
