# platform_frameworks_base for LauncherC

[![snapshot](https://github.com/liu-wanshun/platform_frameworks_base/actions/workflows/publish-snapshot-packages.yml/badge.svg)](https://github.com/liu-wanshun?tab=packages&repo_name=platform_frameworks_base)
[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

旨在为 [LauncherC](https://github.com/liu-wanshun/LauncherC) 提供`quickstep`支持。

## 1. SparseCheckout

只检出`LauncherC`需要的部分代码

```shell
git config core.sparseCheckout true

cp -f .git-sparse-checkout .git/info/sparse-checkout

git checkout --force
```
