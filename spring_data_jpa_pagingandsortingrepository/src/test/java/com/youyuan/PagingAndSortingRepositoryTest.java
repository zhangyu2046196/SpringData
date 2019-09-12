package com.youyuan;

import com.youyuan.dao.UserDao;
import com.youyuan.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author zhangyu
 * @version 1.0
 * @description PagingAndSortingRepository接口测试信息 ,不能根据条件查询分页和查询是根据全表数据
 * @date 2019/3/8 15:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class PagingAndSortingRepositoryTest {

    @Autowired
    private UserDao userDao;

    /**
     * 分页测试
     */
    @Test
    public void testPage(){
        int page=0;//页数的索引，不是具体页数是页数的索引，从0开始
        int size=3;//每页显示的记录数
        Pageable pageable=new PageRequest(page,size);
        Page<Users> p= userDao.findAll(pageable);//返回分页对象
        System.out.println("总记录数量:"+p.getTotalElements());
        System.out.println("总页数:"+p.getTotalPages());
        List<Users> usersList= p.getContent();//返回当前页记录
        for (Users users:usersList){
            System.out.println(users);
        }
    }

    /**
     * 单列排序
     */
    @Test
    public void testSortA(){
        //第一个参数direction是排序规则  如desc倒序 asc正序
        //第二个参数properties是排序实体属性
        Sort sort=new Sort(Sort.Direction.DESC,"userAge");
        List<Users> usersList= (List<Users>) userDao.findAll(sort);
        for (Users users:usersList){
            System.out.println(users);
        }
    }

    /**
     * 多列排序
     */
    @Test
    public void testSortB(){
        //第一个参数direction是排序规则  如desc倒序 asc正序
        //第二个参数properties是排序实体属性
        Sort.Order orderA=new Sort.Order(Sort.Direction.DESC,"userAge");
        Sort.Order orderB=new Sort.Order(Sort.Direction.ASC,"userName");
        Sort sort=new Sort(orderA,orderB);
        List<Users> usersList= (List<Users>) userDao.findAll(sort);
        for (Users users:usersList){
            System.out.println(users);
        }
    }

    /**
     * 分页及排序
     */
    @Test
    public void pageSortTest(){
        int page=0;//页数的索引，不是具体页数是页数的索引，从0开始
        int size=3;//每页显示的记录数
        Sort.Order orderA=new Sort.Order(Sort.Direction.DESC,"userAge");
        Sort.Order orderB=new Sort.Order(Sort.Direction.ASC,"userName");
        Sort sort=new Sort(orderA,orderB);
        Pageable pageable=new PageRequest(page,size,sort);
        Page<Users> p= userDao.findAll(pageable);//返回分页对象
        System.out.println("总记录数量:"+p.getTotalElements());
        System.out.println("总页数:"+p.getTotalPages());
        List<Users> usersList= p.getContent();//返回当前页记录
        for (Users users:usersList){
            System.out.println(users);
        }
    }
}
