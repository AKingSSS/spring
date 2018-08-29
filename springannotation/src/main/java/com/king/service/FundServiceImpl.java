package com.king.service;

import org.springframework.stereotype.Service;

@Service("fundService")
public class FundServiceImpl implements FundService{

    @Override
    public void saveFundInfo(String fundcode,int type) {
        System.out.println("fundcode = " + fundcode);
        System.out.println("type = " + type);
        System.out.println("保存基金信息成功！");
    }

    @Override
    public boolean isHBFund() {
        System.out.println("判断是否是货币基金！");
        return false;
    }
}
