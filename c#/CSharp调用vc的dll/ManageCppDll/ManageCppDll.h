// ManageCppDll.h
#pragma once
//#define NATIVECPPDLL_CLSSS_EXPORTS

#include "..\\NativeCPPDll\NativeCPPDll\NativeCppDll.h"
using namespace System;

namespace ManageCppDll 
{
    public ref class HaspTestManage
    {
		// ��װ������CPerson�Ĺ��г�Ա����
		public:
			HaspTestManage();
			~HaspTestManage();
			int HaspTestManage::HaspCheck2(int feature);
		private:
			// ��CPerson��ָ�룬����������CPerson�ĳ�Ա����
			HaspTestNative *m_pImp;
    };
};