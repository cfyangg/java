package cn.tf.utils;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import cn.tf.domain.*;

//import com.cfwx.rox.web.common.model.entity.SensitiveWord;

/**
 * ���дʿ��ʼ��
 * 
 * @author AlanLee
 *
 */
public class SensitiveWordInit
{
    /**
     * ���дʿ�
     */
    public HashMap sensitiveWordMap;
    
    
    
    

    /**
     * ��ʼ�����д�
     * 
     * @return
     */
    public Map initKeyWord(List<Articel_Words> sensitiveWords)
    {
        try
        {
            // �����дʼ��϶�����ȡ�����дʲ���װ��Set������
            Set<String> keyWordSet = new HashSet<String>();
            for (Articel_Words s : sensitiveWords)
            {
                keyWordSet.add(s.getWordPattern().trim());
            }
            // �����дʿ���뵽HashMap��
            addSensitiveWordToHashMap(keyWordSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sensitiveWordMap;
    }

    /**
     * ��װ���дʿ�
     * 
     * @param keyWordSet
     */
    @SuppressWarnings("rawtypes")
    private void addSensitiveWordToHashMap(Set<String> keyWordSet)
    {
        // ��ʼ��HashMap���󲢿��������Ĵ�С
        sensitiveWordMap = new HashMap(keyWordSet.size());
        // ���д�
        String key = null;
        // ����������Ӧ�ĸ�ʽ�������дʿ�����
        Map nowMap = null;
        // ���������������дʿ�
        Map<String, String> newWorMap = null;
        // ʹ��һ����������ѭ�����дʼ���
        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext())
        {
            key = iterator.next();
            // �������дʿ⣬HashMap�������ڴ���ռ�õ���ͬһ����ַ�����Դ�nowMap����ı仯��sensitiveWordMap����Ҳ����Ÿı�
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++)
            {
                // ��ȡ���дʵ��е��֣������дʿ�����ΪHashMap�����Key��ֵ
                char keyChar = key.charAt(i);

                // �ж�������Ƿ���������дʿ���
                Object wordMap = nowMap.get(keyChar);
                if (wordMap != null)
                {
                    nowMap = (Map) wordMap;
                }
                else
                {
                    newWorMap = new HashMap<String, String>();
                    newWorMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                // ��������ǵ�ǰ���дʵ����һ���֣����ʶΪ��β��
                if (i == key.length() - 1)
                {
                    nowMap.put("isEnd", "1");
                }
                System.out.println("��װ���дʿ���̣�"+sensitiveWordMap);
            }
            System.out.println("�鿴���дʿ�����:" + sensitiveWordMap);
        }
    }
}
