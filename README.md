## 原理
玩家使用武器时激活返回值截获，如果玩家主手持有武器，则使用一个空包欺骗选择器继续运行。
他比使用重新追踪的方法开销更低，且不会选中需要忽略的方块，可以有效避免误操作。
其他版本可以自行编译

攻击指令在逻辑端中只处理数据包，它只需要安装在客户端上即可。
！！！这意味着某些服务器上使用会被视作作弊！！！

## 大饼：
    1.将武器与干扰方块配置迁移到配置文件夹中，这将使mod中的武器可用，
    2.添加方块状态判断，
    3.无实体时重新激活干扰方块选择，
    4.在游戏内添加该功能开关

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
