// ManageCppDll.cpp
#include "stdafx.h"
#include "ManageCppDll.h"
#include <vcclr.h>
namespace ManageCppDll 
{
    // �ڹ��캯���д�����CPerson�Ķ��������������н��ö�������
    // ���еĳ�Ա����ʵ�ֶ���ͨ��ָ��m_pImp������CPerson����Ӧ��Ա����ʵ��
    HaspTestManage::HaspTestManage()
    {
        m_pImp = new HaspTestNative();
    }

    HaspTestManage::~HaspTestManage()
    {
        // ������������ɾ��CPerson����
        delete m_pImp;
    }

	int HaspTestManage::HaspCheck2(int feature)
	{
		return m_pImp->HaspCheck(feature);
	}
  
};